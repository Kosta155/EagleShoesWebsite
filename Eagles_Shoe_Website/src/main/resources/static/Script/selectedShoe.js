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