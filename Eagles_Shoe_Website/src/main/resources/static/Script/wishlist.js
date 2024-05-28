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

function loadData()
{
 let favorites=localStorage.getItem("favorites");
 var favoriteShoes = JSON.parse(favorites);
 
 if (favoriteShoes.length !=0)
 {
	 document.querySelector(".cart-status").style.display ="none";
 }
 console.log(favoriteShoes);
 for (let shoe of favoriteShoes) {
	 console.log(shoe.pictureUrl)
		document.querySelector(".container-featured-shoes").innerHTML +=
		`
        <div class="container-featured-shoes-items">
                        <img src="${shoe.pictureUrl}" width="100%" height="100%">
                         <p class="price">C$ ${shoe.price}</p>
                         <img class="heart">
                         <div class="shoe-desc">
							 <h6 class="name" >${shoe.shoeName}</h6>
	                         <p class="describe">Men's Shoe</p>
	                         <p class="describe">3 Colors</p>
						 </div>
		`;
	} 
}	
const elements2 = document.querySelectorAll("");

console.log(elements2);
elements2.forEach(element => {
	    element.style.color="red";
         element.addEventListener("click", function() {
		 var user = document.getElementById("username").value;
	     element.style.color = "blue";
       
         const shoeId = parseInt(element.id);
         const pictureUrl = element.previousElementSibling.src;
         const price = element.nextElementSibling.innerHTML.slice(3);
         const shoeName = element.nextElementSibling.nextElementSibling.nextElementSibling.id;
         
     

         if(favorites.includes(shoeId))
         {
			favoriteShoes = favoriteShoes.filter(value => value.shoeId !== shoeId)
		 }
		 else{
         favoriteShoes.push(new Shoes(shoeId,shoeName,price,pictureUrl));
         }         
         console.log(favoriteShoes);
    }
    );
});



