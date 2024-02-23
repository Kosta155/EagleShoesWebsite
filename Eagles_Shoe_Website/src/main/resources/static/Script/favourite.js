/**
 * 
 */
const elements2 = document.querySelectorAll(".favourite");


let favorites = [];
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
         const shoeName = element.id;
         if(favorites.includes(shoeName))
         {
			favorites = favorites.filter(name => name !== shoeName);
			localStorage.setItem("favorites",favorites);
		 }
		 else{
         favorites.push(shoeName);
         localStorage.setItem("favorites",favorites);
         }         
         console.log(shoeName);
    }
    });
});

    async function loadData()
    {
      await fetch("/getFavorites")
        .then(res => res.json())
	    .then(dataJSON => {
	     reloadFavorites(dataJSON);
		console.log(dataJSON);
	})
	}
	
	function reloadFavorites(dataJSON)
	{
		favorites=[]
		for(let value of dataJSON){
        favorites.push(value.shoeName);
        localStorage.setItem("favorites",favorites);
    }
	}

    function sendDataToController(shoeName) {
  fetch('/addFavourite', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({ shoeName: shoeName })
  })
  .then(response => response.json())
  .then(responseData => {
    console.log('Response from server:', responseData);
  })
  .catch(error => {
    console.error('Error:', error);
  });
}