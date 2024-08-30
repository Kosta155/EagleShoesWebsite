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