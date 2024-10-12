/**
 * 
 */
let currentImage = 0;
    const slideShowImages = document.querySelectorAll(".Slide-Images");
    const tinyImages = document.querySelectorAll(".columns img");
    
    const prev = document.querySelector(".prev");
    const next = document.querySelector(".next");

    document.addEventListener("DOMContentLoaded", initialize);

    function initialize() {
        updateSlide(currentImage);
    }

    tinyImages.forEach((element,index) =>{	
	 element.addEventListener("click", function ()
	 {
		slideShowImages[currentImage].classList.add("hidden");
        tinyImages[currentImage].style.opacity = "0.5";
		 currentImage = index;
		 updateSlide(currentImage);
		
	 })
	 
	 });
    prev.addEventListener("click", function () {
        changeSlide(-1);
    });

    next.addEventListener("click", function () {
        changeSlide(1);
    });

    function changeSlide(direction) {
        slideShowImages[currentImage].classList.add("hidden");
        tinyImages[currentImage].style.opacity = "0.5";

        currentImage += direction;

        if (currentImage < 0) {
            currentImage = slideShowImages.length - 1;
        } else if (currentImage >= slideShowImages.length) {
            currentImage = 0;
        }

        updateSlide(currentImage);
    }

    function updateSlide(index) {
        slideShowImages[index].classList.remove("hidden");
        tinyImages[index].style.opacity = "1";
    }
    
    
    const dropdown = document.querySelectorAll(".product-details-dropdown");
    const control = document.querySelectorAll(".product-details-control");
    const icon = document.querySelectorAll(".desc-icons");
   
    
    control.forEach((element,index) =>{	
	 element.addEventListener("click", function ()
	 {
		
		 if(dropdown[index].classList.contains("dropdown-hidden"))
		 {
			
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