const app = Vue.createApp({});

app.component('settings_component', {
    template:
        `        
    `,
    data() {},
    methods: {
        deleteHabits(){
            axios.delete()
                .then(response => {this.habits = response.data; console.log(response.data)});
        }
    },

});
app.mount('#settingsApp');
