var fshoes;
class Shoes{
	
     constructor(shoeId,shoeName,price,pictureUrl)
     {
		 this.shoeId=shoeId;
		 this.shoeName=shoeName;
		 this.price=price;
		 this.pictureUrl=pictureUrl;
		 this.shoeBrand= null;
	    this.shoeType= null;
	    this.gender= null;
	    this.shoeDate = null;
	     this.discount= null ;
	     this.color= null;
	     this.size= null;
	    this.orderId= null;
	     this.picture2URL= null;
	     this.picture3URL= null;
	     this.picture4URL= null;
		 
	 }
}

const elements2 = document.querySelectorAll(".favourite");
let favorites = [];
let favoriteShoes=[];



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
         const shoeId = parseInt(element.id);
         const pictureUrl = element.previousElementSibling.src;
         const price = element.nextElementSibling.innerHTML.slice(3);
         const shoeName = element.nextElementSibling.nextElementSibling.nextElementSibling.id;
         
         console.log(pictureUrl);
         console.log(price);
         console.log(shoeId);
         console.log(shoeName);

         if(favorites.includes(shoeId))
         {
			favorites = favorites.filter(id => id !== shoeId);
			favoriteShoes = favoriteShoes.filter(value => value.shoeId !== shoeId)
		 }
		 else{
         favorites.push(shoeId);
         favoriteShoes.push(new Shoes(shoeId,shoeName,price,pictureUrl));
         }         
         console.log(favorites);
         console.log(favoriteShoes);
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
		favoriteShoes=[];
		console.log(dataJSON);
		for(let value of dataJSON){
		fshoes = new Shoes(value.shoeId,value.shoeName,value.price,value.pictureURL);
        favorites.push(value.shoeId);
        favoriteShoes.push(fshoes);
        var favoriteShoesJSON = JSON.stringify(favoriteShoes);
        localStorage.setItem("favorites", favoriteShoesJSON);
        elements2.forEach(x => {
			if(favorites.includes(parseInt(x.id)))
			{
				x.style.color = "black";
			}
		})

    }

	}

window.addEventListener("beforeunload", async function(e) {
	 
   var favoriteShoesJSON = JSON.stringify(favoriteShoes);
        localStorage.setItem("favorites", favoriteShoesJSON);
  var user = document.getElementById("username").value;
		if (user=="anonymousUser")
		{
			window.location.href = "/login";
			return false;
		}
  if (!favoriteShoes.length)
  {
	  const response = await fetch("/favorites/saveEmpty", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      }
    });
  }; 
  try {
    const response = await fetch("/favorites/save", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(favoriteShoes)
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

