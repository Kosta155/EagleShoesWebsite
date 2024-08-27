const search = document.querySelector("#searchbar");
const overlay1 = document.querySelector(".overlay1");
const modal1 = document.querySelector(".modal1");
const cancel1 = document.querySelectorAll(".cancel2");

// Event listener for addAddress element
search.addEventListener("click", function() {
    overlay1.classList.remove("hidden1");
    modal1.classList.remove("hidden1");
    document.documentElement.style.overflow = 'hidden';
});

// Event listener for cancel elements
cancel1.forEach(can => {
    can.addEventListener("click", function() {
        overlay1.classList.add("hidden1");
        modal1.classList.add("hidden1");
        document.documentElement.style.overflow = 'auto';
    });
});