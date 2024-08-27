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

