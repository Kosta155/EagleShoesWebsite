/**
 * 
 */
const dropdown = document.querySelectorAll(".product-details-dropdown");
    const control = document.querySelectorAll(".product-details-control");
    const icon = document.querySelectorAll(".desc-icons");
   
    
    control.forEach((element,index) =>{	
		
	 element.addEventListener("click", function ()
	 {
		 
		 
		 
		   
		 
		 if(dropdown[index].classList.contains("dropdown-hidden"))
		 {
			 dropdown.forEach((dropdown, i) => {
            dropdown.classList.add("dropdown-hidden");
            icon[i].classList.add("fa-angle-down");
            icon[i].classList.remove("fa-angle-up");
       		 });
			 dropdown[index].classList.remove("dropdown-hidden");
		     icon[index].classList.remove("fa-angle-down");
		     icon[index].classList.add("fa-angle-up");
		 }
		 else
		 { 
			 dropdown[index].classList.add("dropdown-hidden");
		     icon[index].classList.add("fa-angle-down");
		     icon[index].classList.remove("fa-angle-up"); 
		 }
	 })
	 
	 });