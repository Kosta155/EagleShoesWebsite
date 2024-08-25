/**
 * 
 */
const addItem = document.querySelector("#add");
const overlay = document.querySelector(".overlay");
const modal = document.querySelector(".modal");
const cancel = document.querySelectorAll(".cancel");

// Event listener for addAddress element
addItem.addEventListener("click", function() {
    overlay.classList.remove("hidden");
    modal.classList.remove("hidden");
    document.documentElement.style.overflow = 'hidden';
});

// Event listener for cancel elements
cancel.forEach(can => {
    can.addEventListener("click", function() {
        overlay.classList.add("hidden");
        modal.classList.add("hidden");
        document.documentElement.style.overflow = 'auto';
    });
});

const search = document.querySelector("#searchbar");
const overlay1 = document.querySelector(".overlay1");
const modal1 = document.querySelector(".modal1");
const cancel1 = document.querySelectorAll(".cancel2");

// Event listener for addAddress element
search.addEventListener("click", function() {
    overlay1.classList.remove("hidden1");
    modal1.classList.remove("hidden1");
    document.documentElement.style.overflow = 'hidden1';
});

// Event listener for cancel elements
cancel.forEach(can => {
    can.addEventListener("click", function() {
        overlay1.classList.add("hidden1");
        modal1.classList.add("hidden1");
        document.documentElement.style.overflow = 'auto';
    });
});