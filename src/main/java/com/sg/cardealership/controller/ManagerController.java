/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealership.controller;

import com.sg.cardealership.entity.CarModel;
import com.sg.cardealership.entity.InventoryReportInterface;
import com.sg.cardealership.entity.Make;
import com.sg.cardealership.entity.Sale;
import com.sg.cardealership.entity.Special;
import com.sg.cardealership.entity.User;
import com.sg.cardealership.entity.Vehicule;
import com.sg.cardealership.repository.ContactRepository;
import com.sg.cardealership.repository.MakeRepository;
import com.sg.cardealership.repository.SaleRepository;
import com.sg.cardealership.repository.SpecialRepository;
import com.sg.cardealership.repository.UserRepository;
import com.sg.cardealership.repository.VehiculeRepository;
import com.sg.cardealership.view.CarDealershipView;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.sg.cardealership.repository.CarModelRepository;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ManagerController {
    
    @Autowired
    VehiculeRepository vehiculeRepository;
    
    @Autowired
    CarDealershipView carDealershipView;
    
    @Autowired
    ContactRepository contactRepository;
    
    @Autowired
    MakeRepository makeRepository;
    
    @Autowired
    CarModelRepository carModelRepository;
    
    @Autowired
    SaleRepository saleRepository;
    
    @Autowired
    SpecialRepository specialRepository;
    
    @Autowired
    UserRepository userRepository;
    
    Set<ConstraintViolation<Vehicule>> vehiculeViolations = new HashSet<>();
    Set<ConstraintViolation<Sale>> saleViolations = new HashSet<>();

    @GetMapping("/login")
    public String displayLogin(Model model) {
        model.addAttribute("activePage", "login");
        model.addAttribute("error","");
        return carDealershipView.displayLoginPage();
    }
    
    
    @PostMapping("/login")
    public String performLogin(String email,String password, Model model) {
        
        User user = userRepository.findByEmail(email);
        if (user != null && password.equals(user.getPassword())){
            user.setPassword("");
            model.addAttribute("user",user); 
            switch(user.getRole()){
                case "Admin":
                case "Sales":
                    return carDealershipView.displayLoginSucessPage();
                case "Disabled":
                    model.addAttribute("error", "User is disabled");
                    return carDealershipView.displayLoginPage();
                default:
                    model.addAttribute("error", "Invalid username/password");
                    return carDealershipView.displayLoginPage();

            }
        }
         model.addAttribute("error", "Invalid username/password");
        return carDealershipView.displayLoginPage();
    }
    
    
    @GetMapping("/account/changePassword")
    public String displayChangePassword(Model model) {
        return carDealershipView.displayChangePasswordPage();
    }
    
    @PostMapping("/account/changePassword")
    public String changePassword(String password,HttpServletRequest request, Model model) {
        String userId = request.getParameter("userId");

        User user = userRepository.findById(Integer.parseInt(userId)).orElse(null);
        if (user != null){
            user.setPassword(password);
            userRepository.save(user);
        }
        return "redirect:/home";
    }

    @GetMapping("/admin/vehicules")
    public String displayAdminVehicules(Model model) {
        
        
        model.addAttribute("activePage", "admin");

        return carDealershipView.displayAdminVehiculesPage();
    }
    
    @GetMapping("/admin/addVehicule")
    public String displayAddVehicule(Model model) {
        
        List<Make> makes = makeRepository.findAll();
        model.addAttribute("activePage", "admin");
        model.addAttribute("makes", makes);
        model.addAttribute("errors",vehiculeViolations);
        return carDealershipView.displayAddVehiculePage();
    }
    
    @PostMapping("/admin/addVehicule")
    public String addVehicule(Vehicule vehicule,BindingResult result, HttpServletRequest request, Model model) {



        String carModelId = request.getParameter("modelId");
        CarModel carModel = carModelRepository.findById(Integer.parseInt(carModelId)).orElse(null);
        //set the model and availabilty and complete the addition of the vehicule

        vehicule.setCarModel(carModel);
        vehicule.setAvailable(true);
        vehicule.setFeatured(false);
       
        vehiculeRepository.save(vehicule);
       try{
           Part image = request.getPart("file"); // Retrieves <input type="file" name="file">
           String fileName = image.getSubmittedFileName();
           saveImage(image, fileName, vehicule.getVehiculeId());
       }catch(IOException | ServletException e){
       }
           
//        model.addAttribute("vehicule", vehicule);
        return "redirect:/admin/editVehicule/"+vehicule.getVehiculeId();
    }
    
    @GetMapping("/admin/editVehicule/{id}")
    public String editVehicule(@PathVariable int id, Model model) {
        Vehicule vehicule = vehiculeRepository.findById(id).orElse(null);
        List<Make> makes = makeRepository.findAll();
        model.addAttribute("vehicule", vehicule);
        model.addAttribute("makes", makes);
        return "editVehicule";
    }
    
    @PostMapping("/admin/editVehicule")
    public String performEditVehicule(Vehicule vehicule, HttpServletRequest request, BindingResult result) {
        Vehicule managedStateVehicule = vehiculeRepository.findById(vehicule.getVehiculeId()).orElse(null);
        String carModelId = request.getParameter("modelId");
        CarModel carModel = carModelRepository.findById(Integer.parseInt(carModelId)).orElse(null);
        managedStateVehicule.setCarModel(carModel);
        managedStateVehicule.setType(vehicule.getType());
        managedStateVehicule.setYear(vehicule.getYear());
        managedStateVehicule.setTransmission(vehicule.getTransmission());
        managedStateVehicule.setExteriorColor(vehicule.getExteriorColor());
        managedStateVehicule.setInteriorColor(vehicule.getInteriorColor());
        managedStateVehicule.setMileage(vehicule.getMileage());
        managedStateVehicule.setVINNumber(vehicule.getVINNumber());
        managedStateVehicule.setMSRP(vehicule.getMSRP());
        managedStateVehicule.setSalePrice(vehicule.getSalePrice());
        managedStateVehicule.setDescription(vehicule.getDescription());
        managedStateVehicule.setFeatured(vehicule.isFeatured());
        vehiculeRepository.save(managedStateVehicule);
        try{
           Part image = request.getPart("file"); // Retrieves <input type="file" name="file">
           String fileName = image.getSubmittedFileName();
           if(!fileName.equals("")){
                saveImage(image, fileName, managedStateVehicule.getVehiculeId());
           }
       }catch(IOException | ServletException e){
       }
        
        return "redirect:/admin/vehicules";
    }
    
    @GetMapping("/sales")
    public String displaySales(Model model) {
        
        model.addAttribute("activePage", "sales");

        return carDealershipView.displaySalesPage();
    }
    
    
    //find a superhumans by its ID
    @GetMapping("/sales/purchase/{id}")
    public String displaySaleForm(@PathVariable int id, Model model) {
        Vehicule vehicule = vehiculeRepository.findById(id).orElse(null);
        model.addAttribute("activePage", "sales");

        model.addAttribute("vehicule",vehicule);
        model.addAttribute("errors",saleViolations);
        
        
        return carDealershipView.displayPurchasePage();
    }
    
    @PostMapping("/sales/purchase/add")
    public String addSale( @Valid Sale sale,BindingResult result, HttpServletRequest request, Model model) {
       String vehiculeId = request.getParameter("vehiculeId");
       String userId = request.getParameter("userId");
       User user = userRepository.findById(Integer.parseInt(userId)).orElse(null);
       Vehicule vehicule = vehiculeRepository.findById(Integer.parseInt(vehiculeId)).orElse(null);
       Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
        saleViolations = validate.validate(sale);
       if(result.hasErrors()) {
           model.addAttribute("vehicule",vehicule);
           model.addAttribute("sale",sale);
           model.addAttribute("errors",saleViolations);
            return carDealershipView.displayPurchasePage();
        }
       //set the vhicule availabilty to false and complete the sale
        vehicule.setAvailable(false);
        sale.setVehicule(vehicule);
        sale.setUser(user);
        System.out.print("test");
       
        saleRepository.save(sale);
        
        return "redirect:/home";
    }
    
        
    @GetMapping("/admin/users")
    public String displayUsers(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("activePage", "admin");
        model.addAttribute("users", users);
        return carDealershipView.displayUsersPage();
    }
    
    @GetMapping("/admin/addUser")
    public String displayAddUser(Model model) {
        model.addAttribute("activePage", "admin");
        return carDealershipView.displayAddUserPage();
    }
    
    @PostMapping("/admin/addUser")
    public String addUser(User user, Model model) {
        model.addAttribute("activePage", "admin");
        userRepository.save(user);
        return "redirect:/admin/users";
    }
    
    @GetMapping("/admin/editUser/{id}")
    public String displayAddUser(@PathVariable int id, Model model) {
        User user = userRepository.findById(id).orElse(null);
        
        model.addAttribute("activePage", "admin");
        model.addAttribute("user", user);
        return carDealershipView.displayEditUserPage();
    }
    
    @PostMapping("/admin/editUser")
    public String editUser(User user, Model model) {
        User managedStateUser = userRepository.findById(user.getUserId()).orElse(null);
        managedStateUser.setFirstName(user.getFirstName());
        managedStateUser.setLastName(user.getLastName());
        managedStateUser.setEmail(user.getEmail());
        managedStateUser.setRole(user.getRole());
        if(!user.getPassword().equals("")) {
            managedStateUser.setPassword(user.getPassword());
        }
        userRepository.save(managedStateUser);
        return "redirect:/admin/users";
    }
    
    @GetMapping("/admin/makes")
    public String displayMakes(Model model) {
        List<Make> makes = makeRepository.findAll();
        model.addAttribute("activePage", "admin");
        model.addAttribute("makes", makes);
        return carDealershipView.displayMakesPage();
    }
    
    @PostMapping("/admin/addMake")
    public String addMake(String name, HttpServletRequest request) {
        String userId = request.getParameter("userId");
        User user = userRepository.findById(Integer.parseInt(userId)).orElse(null);
        if(user != null){
            Make make = new Make();
            make.setName(name);
            make.setDateAdded(LocalDate.now());
            make.setUser(user);
            makeRepository.save(make);
        }
        
        return "redirect:/admin/makes";
    }
    
    
    @GetMapping("/admin/models")
    public String displayModels(Model model) {
        List<CarModel> carModels = carModelRepository.findAll();
        List<Make> makes = makeRepository.findAll();
        model.addAttribute("activePage", "admin");
        model.addAttribute("models", carModels);
        model.addAttribute("makes", makes);
        return carDealershipView.displayModelsPage();
    }
    
    @PostMapping("/admin/addModel")
    public String addModel(String name, int makeId, HttpServletRequest request) {
        String userId = request.getParameter("userId");
        User user = userRepository.findById(Integer.parseInt(userId)).orElse(null);
        Make make = makeRepository.findById(makeId).orElse(null);
        if(user != null){
            
            CarModel carModel = new CarModel();
            carModel.setName(name);
            carModel.setMake(make);
            carModel.setDateAdded(LocalDate.now());
            carModel.setUser(user);
            carModelRepository.save(carModel);
        }
        
        return "redirect:/admin/models";
    }
    
    @GetMapping("/admin/specials")
    public String displayAdminSpecials(Model model) {
        List<Special> specials = specialRepository.findAll();
        model.addAttribute("activePage", "admin");
        model.addAttribute("specials", specials);
        return carDealershipView.displayAdminSpecialsPage();
    }
    
    @PostMapping("/admin/addSpecial")
    public String addSpecial(Special special, HttpServletRequest request) {
        
        Special newSpecial = new Special();
        newSpecial.setTitle(special.getTitle());
        newSpecial.setDescription(special.getDescription());
        specialRepository.save(special);
        
        return "redirect:/admin/specials";
    }
    
    @PostMapping("/admin/deleteSpecial")
    public String deleteSpecial( int specialId, HttpServletRequest request) {
        
        specialRepository.deleteById(specialId);
        
        return "redirect:/admin/specials";
    }
    
    @GetMapping("/reports/index")
    public String displayReports(Model model) {
        return carDealershipView.displayReportsPage();
    }
    
    @GetMapping("/reports/sales")
    public String displaySalesReport(Model model) {
        return carDealershipView.displaySalesReportPage();
    }
    
        @GetMapping("/reports/inventory")
    public String displayInventoryReport(Model model) {
        List<InventoryReportInterface> newVehiculesReport = vehiculeRepository.findInventoryReportByType("New");
        List<InventoryReportInterface> usedVehiculesReport = vehiculeRepository.findInventoryReportByType("Used");
        model.addAttribute("newReport", newVehiculesReport);
        model.addAttribute("usedReport", usedVehiculesReport);

        return carDealershipView.displayInventoryReportPage();
    }
    
    
    
    public void saveImage(Part image,String fileName, int id){
        try{
            String[] tokens = fileName.split("\\.(?=[^\\.]+$)");
//            String extension = tokens[1];
            
            InputStream fileContent = image.getInputStream();

            File f = new File("src/main/resources/static/images/inventory-" + id);

            OutputStream os = new FileOutputStream(f);
            byte[] buf = new byte[1024];
            int len;

            while ((len = fileContent.read(buf)) > 0) {
                os.write(buf, 0, len);
            }

            os.close();
            fileContent.close();
        }
        catch(IOException e){
        }
        
    }
    
    
}
