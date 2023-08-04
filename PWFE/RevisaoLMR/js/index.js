const carouselVisible = document.querySelector(".carousel-visible");
const carousel = carouselVisible.querySelector(".carousel");
const prevButton = document.querySelectorAll(".prvItem");
const nextButton = document.querySelectorAll(".nxtItem");

let currentIndex = 0;

function moveToNextItem() {
    const itemWidth = carousel.querySelector(".carousel-item").offsetWidth;
    const containerWidth = carouselVisible.offsetWidth;
    const maxVisibleIndex = Math.floor(carousel.scrollWidth / itemWidth) - Math.floor(containerWidth / itemWidth);
    
    if (currentIndex < maxVisibleIndex) {
        currentIndex++;
        carousel.style.transform = `translateX(-${currentIndex * itemWidth}px)`;
    }
    checkLastItem();
}

function moveToPrevItem() {
    const itemWidth = carousel.querySelector(".carousel-item").offsetWidth;
    
    if (currentIndex > 0) {
        currentIndex--;
        carousel.style.transform = `translateX(-${currentIndex * itemWidth}px)`;
    }
    checkLastItem();
}

function checkLastItem() {
    const itemWidth = carousel.querySelector(".carousel-item").offsetWidth;
    const containerWidth = carouselVisible.offsetWidth;
    const visibleItems = Math.floor(containerWidth / itemWidth);
    const maxVisibleIndex = Math.floor(carousel.scrollWidth / itemWidth) - visibleItems;

    if (currentIndex >= maxVisibleIndex) {
        nextButton.forEach(button => {
            button.classList.add("disabled");
            button.disabled = false;
        });
    } else {
        nextButton.forEach(button => {
            button.classList.remove("disabled");
            button.disabled = false;
        });
    }

    if (currentIndex === 0) {
        prevButton.forEach(button => {
            button.classList.add("disabled");
            button.disabled = false;
        });
    } else {
        prevButton.forEach(button => {
            button.classList.remove("disabled");
            button.disabled = false;
        });
    }
}

nextButton.forEach(button => {
    button.addEventListener("click", moveToNextItem);
});
prevButton.forEach(button => {
    button.addEventListener("click", moveToPrevItem);
});

// Verificar estado inicial do carrossel
checkLastItem();