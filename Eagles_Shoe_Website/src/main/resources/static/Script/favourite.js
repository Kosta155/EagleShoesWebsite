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
         const shoeId = element.id;
         if(favorites.includes(shoeId))
         {
			favorites = favorites.filter(id => id !== shoeId);
		 }
		 else{
         favorites.push(shoeId);
         }         
         console.log(shoeId);
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
		console.log(dataJSON);
		for(let value of dataJSON){
        favorites.push(value.shoeId);
        localStorage.setItem("favorites",favorites);
        elements2.forEach(x => {
			if(favorites.includes(parseInt(x.id)))
			{
				x.style.color = "black";
			}
		})
    }
	}

window.addEventListener("beforeunload", async function(e) {
	 
  if (!favorites.length) return; // Skip if no favorites
  try {
    const response = await fetch("/favorites/save", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(favorites)
    });

    if (!response.ok) {
      // Handle errors gracefully, e.g., log, display message
      console.error("Error saving favorites:", response.statusText);
    }
  } catch (error) {
    // Handle network errors
    console.error("Error sending favorites:", error);
  }
});


    function sendDataToController(shoeId) {
  fetch('/addFavourite', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({ shoeId: shoeId })
  })
  .then(response => response.json())
  .then(responseData => {
    console.log('Response from server:', responseData);
  })
  .catch(error => {
    console.error('Error:', error);
  });
}

