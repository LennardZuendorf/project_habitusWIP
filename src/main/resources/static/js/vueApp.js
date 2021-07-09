import settingsComponent from "./vue/settingsComponent.js";
import habitComponent from "./vue/habitComponent.js";
import goalComponent from "./vue/habitComponent.js";

const vue = Vue.createApp({});

vue.component('settings-component',settingsComponent)
vue.component('habit-component',habitComponent)
vue.component('goal-component', goalComponent)


vue.mount('#vue-app');