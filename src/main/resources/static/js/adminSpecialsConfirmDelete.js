

$("#delete-form").onsubmit = (e) => {
  e.preventDefault()
  const confirm = confirm('Are you sure you want to delete this Special?');
  if (confirm) {
    console.log('submitted')
  }
}