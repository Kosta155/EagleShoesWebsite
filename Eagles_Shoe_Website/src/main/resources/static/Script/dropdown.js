/**
 * 
 */

const elements31 = document.querySelectorAll("[class$='-dropdown']");
elements31.forEach(element => {
element.addEventListener("mouseover", function(){
	                switch(element.className) {
			case "men-dropdown":
                document.querySelector(".men-dropdown").style.display = "flex";
                break;
            case "boys-dropdown":
                document.querySelector(".boys-dropdown").style.display = "flex";
                break;
            case "girls-dropdown":
                document.querySelector(".girls-dropdown").style.display = "flex";
                break;
            case "sales-dropdown":
                document.querySelector(".sales-dropdown").style.display = "flex";
                break;
            case "sport-dropdown":
                document.querySelector(".sport-dropdown").style.display = "flex";
                break;
            case "women-dropdown":
                document.querySelector(".women-dropdown").style.display = "flex";
                break;						}
})
});

elements31.forEach(element => {
element.addEventListener("mouseout", function(){
	                switch(element.className) {
			case "men-dropdown":
                document.querySelector(".men-dropdown").style.display = "none";
                break;
            case "boys-dropdown":
                document.querySelector(".boys-dropdown").style.display = "none";
                break;
            case "girls-dropdown":
                document.querySelector(".girls-dropdown").style.display = "none";
                break;
            case "sales-dropdown":
                document.querySelector(".sales-dropdown").style.display = "none";
                break;
            case "sport-dropdown":
                document.querySelector(".sport-dropdown").style.display = "none";
                break;
            case "women-dropdown":
                document.querySelector(".women-dropdown").style.display = "none";
                break;						}
})
});



const elements = document.querySelectorAll(".dropdown");
	elements.forEach(element => {
    element.addEventListener("mouseover", function() {
        switch(element.innerHTML) {
            case "Men":
                document.querySelector(".men-dropdown").style.display = "flex";
                break;
            case "Boys":
                document.querySelector(".boys-dropdown").style.display = "flex";
                break;
            case "Girls":
                document.querySelector(".girls-dropdown").style.display = "flex";
                break;
            case "Sales":
                document.querySelector(".sales-dropdown").style.display = "flex";
                break;
            case "Sport":
                document.querySelector(".sport-dropdown").style.display = "flex";
                break;
            case "Women":
                document.querySelector(".women-dropdown").style.display = "flex";
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
 
