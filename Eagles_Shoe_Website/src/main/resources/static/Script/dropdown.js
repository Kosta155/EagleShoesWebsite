/**
 * 
 */


const elements = document.querySelectorAll(".dropdown");
	elements.forEach(element => {
    element.addEventListener("mouseover", function() {
        switch(element.innerHTML) {
            case "Men":
                document.querySelector(".men-dropdown").style.display = "block";
                break;
            case "Boys":
                document.querySelector(".boys-dropdown").style.display = "block";
                break;
            case "Girls":
                document.querySelector(".girls-dropdown").style.display = "block";
                break;
            case "Sales":
                document.querySelector(".sales-dropdown").style.display = "block";
                break;
            case "Sport":
                document.querySelector(".sport-dropdown").style.display = "block";
                break;
            case "Women":
                document.querySelector(".women-dropdown").style.display = "block";
                break;
            default:
                // Handle default case if needed
                break;
        }
    });

    element.addEventListener("mouseout", function() {
        switch(element.innerHTML) {
            case "Men":
                document.querySelector(".men-dropdown").style.display = "none";
                break;
            case "Boys":
                document.querySelector(".boys-dropdown").style.display = "none";
                break;
            case "Girls":
                document.querySelector(".girls-dropdown").style.display = "none";
                break;
            case "Sales":
                document.querySelector(".sales-dropdown").style.display = "none";
                break;
            case "Sport":
                document.querySelector(".sport-dropdown").style.display = "none";
                break;
            case "Women":
                document.querySelector(".women-dropdown").style.display = "none";
                break;
            case "Women":
                document.querySelector(".women-dropdown").style.display = "none";
                break;
            default:
                // Handle default case if needed
                break;
        }
    });
});

		
		
const profile = document.querySelector(".fa-user");
profile.addEventListener("mouseover", function() {
    const e = document.querySelector(".profile-dropdown");
     const e2 = document.querySelector(".point");
    e.style.display = "block";
    e2.style.display = "block";
    e.style.height = "160px";
    e.style.width = "160px";
});
const profile2 = document.querySelector(".profile-dropdown");
profile2.addEventListener("mouseout", function() {
    const e = document.querySelector(".profile-dropdown");
     const e2 = document.querySelector(".point");
    e.style.display = "none";
    e2.style.display = "none";
});



/**
 * 
 * profile.addEventListener("mouseout", function() {
    const e = document.querySelector(".profile-dropdown");
    e.style.display = "none";
});
 */
 
