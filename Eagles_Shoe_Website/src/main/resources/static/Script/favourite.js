/**
 * 
 */
const elements2 = document.querySelectorAll(".favourite");

elements2.forEach(element => {
    element.addEventListener("click", function() {
		var user = document.getElementById("username").value;
		if (user=="anonymousUser")
		{
			window.location.href = "/login";
			return false;
		}
		
		else{
        if (element.style.color == "black") {
            element.style.color = "silver";
        } else {
            element.style.color = "black";

        }
         const shoeName = element.nextElementSibling.nextElementSibling.nextElementSibling.innerText;
         console.log(shoeName);
         sendDataToController(shoeName);
    }
    });
});

    function sendDataToController(shoeName) {
        fetch('/addFavourite?shoeName=' + shoeName, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => response.text())
        .then(responseData => {
            console.log('Response from server:', responseData);
        })
        .catch(error => {
            console.error('Error:', error);
        });
    }