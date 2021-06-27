const app = Vue.createApp({});

app.component('habit_component', {
    template:
        `
        <div v-for="habit in habits">
          {{ habit.hid }}
          {{ getHabit(habit.hid) }}
        </div>
        
    `,
    data() {
        return {
            habits: [
                { hid: 999}
                ],
            };
        },
    methods: {


        async getHabit(hidInput){
                let URL = 'http://localhost:8080/habits/'+hidInput.toString();
                let response;
                await axios.get(URL).then(resp => {response = resp.data;});
                console.log(response)
        }
    }
});

app.mount('#habitApp');