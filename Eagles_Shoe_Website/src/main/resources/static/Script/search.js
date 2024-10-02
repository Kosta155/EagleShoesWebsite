const search = document.querySelector("#searchbar");
const overlay1 = document.querySelector(".overlay1");
const modal1 = document.querySelector(".modal1");
const cancel1 = document.querySelectorAll(".cancel2");
const empty = document.querySelector("#empty");
const e = document.querySelector("#bigSerch");
         
// Event listener for addAddress element
search.addEventListener("click", function() {
    overlay1.classList.remove("hidden1");
    modal1.classList.remove("hidden1");
    e.focus();
    document.documentElement.style.overflow = 'hidden';
});

empty.addEventListener("click", () => {
    e.value = "";
});

// Event listener for cancel elements
cancel1.forEach(can => {
    can.addEventListener("click", function() {
        overlay1.classList.add("hidden1");
        modal1.classList.add("hidden1");
        document.documentElement.style.overflow = 'auto';
    });
});

 if (typeof shoes !== 'undefined') {
    console.log(shoes);
    
} 

function searchShoes() {
	 var query = document.querySelector("#bigSerch").value;
     query = query.toLowerCase();      
   const exactMatches = shoes.filter(shoe => 
    shoe.shoeName.toLowerCase() === query
   );

   const startsWithMatches = shoes.filter(shoe => 
    shoe.shoeName.toLowerCase().startsWith(query) && !exactMatches.includes(shoe)
   );
   
    const hasMatches = shoes.filter(shoe => 
    shoe.shoeName.toLowerCase().includes(query) && !exactMatches.includes(shoe) && !startsWithMatches.includes(shoe)
   );

   
   const filteredOrders = exactMatches.concat(startsWithMatches,hasMatches);
      
    const resultsContainer = document.querySelector(".SuggestedShoes");
    
    resultsContainer.innerHTML = '';

    // Display the filtered results
    filteredOrders.forEach(shoe => {
       resultsContainer.innerHTML+= 
       `<div class="shoeSearched">	
            <div class="modal-content-img"> 
             	<img id="pictureURL" src="${shoe.pictureURL}" style="width:100px;" > 
             </div> 
             <div class="modal-content-text"> 
             	<h5>${shoe.shoeName}</h5> 
             	<p>${shoe.price}$</p> 
             </div>
          </div>`
    });

    // If no results found, show a message
    if (filteredOrders.length === 0) {
        resultsContainer.innerHTML = 'No matching orders found';
    }
	
}
