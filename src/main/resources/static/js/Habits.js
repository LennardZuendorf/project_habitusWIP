const habitApp ={
    data(){
        return{
            addedHabit : "",
            habits : [
                { hid: 676,
                    tag: 'Eat a Sandwich',
                    frequency: `WEEKLY`,
                    quantity: 3,
                    uid: 587,
                    finished: false
                },
                {
                    hid: 676,
                    tag: 'Eat a Sandwich',
                    frequency: `DAILY`,
                    quantity: 3,
                    uid: 587,
                    finished: false
                }
            ],
        }
    },

    methods:{

        markFinished(habit){
            habit.finished =! habit.finished
        },

        newHabit(tag, frequency, quantity){
            let newHabit = {
                hid: 676,
                tag: document.getElementById(newHabitTag),
                frequency: document.getElementById(newHabitFrequency),
                quantity: document.getElementById(newHabitQuantity),
                uid: 587,
                finished: false
            }
            this.habits.push(newHabit);
            //space for API Call with axios
        },
        updateHabit(){
            let changedHabit = {
                hid: 676,
                tag: document.getElementById(newHabitTag),
                frequency: document.getElementById(newHabitFrequency),
                quantity: document.getElementById(newHabitQuantity),
                uid: 587,
                finished: false
            }
        }
    }
}
Vue.createApp(habitApp).mount("#habits")