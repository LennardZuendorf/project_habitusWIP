//example found at: https://www.w3schools.com/howto/howto_js_toggle_dark_mode.asp
// function to set a color mode and save to localstorage
function toggleColor() {

    //changing color mode
    const element = document.body;
    element.classList.toggle("light-mode");

    //saving color mode
    if (element.classList.contains("light-mode") === true){
        localStorage.setItem("colorMode", "light");
    }else localStorage.setItem("colorMode", "dark");

    //changing color mode icon and color of the icon
    const x = document.getElementById("colorModeIcon")

    if(localStorage.getItem("colorMode")==="light"){
        x.classList.remove("fa-sun");
        x.classList.add("fa-moon");
        x.style.color="var(--goal-color)";
    }else{
        x.classList.remove("fa-moon");
        x.classList.add("fa-sun");
        x.style.color="var(--habit-color)";
    }
}

// set correct color mode immediately
(function () {
    if (localStorage.getItem('colorMode') === 'light') {
        toggleColor();
    }
})();
