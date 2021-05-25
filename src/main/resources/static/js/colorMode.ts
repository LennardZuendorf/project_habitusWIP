//color mode implementation found at: https://dev.to/ananyaneogi/create-a-dark-light-mode-switch-with-css-variables-34l8, by Ananya Neogi

//#color mode
//switching colors
const toggleSwitch = document.querySelector('.theme-switch input[type="checkbox"]');

function switchTheme(e) {
    if (e.target.checked) {
        document.documentElement.setAttribute('data-theme', 'dark');
    }
    else {
        document.documentElement.setAttribute('data-theme', 'light');
    }
}

toggleSwitch.addEventListener('change', switchTheme, false);

//saving color mode



//#icon switcher
//changing color mode icon
function changeIcon()
{

}
