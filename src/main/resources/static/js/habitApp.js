const app = Vue.createApp({});

app.component('habit_component', {
    template:
        `         
          <!-- new habit form-->
          <div class="container-fluid">
    
              <!-- new habit form -->
              
               <form id="newHabitForm">
                 <div class = "row" style="padding-top: 2%">
                    
                    <!-- tag input -->
                    <div class="col-lg-4">
                        <div class="form-outline">
                          <input v-model="newHabitTag" type="text" id="newHabitTag" class="form-control" />
                          <label class="form-label" for="newHabitTag" style>My new habit is:</label>
                        </div>
                    </div>
                    <!-- tag input -->

                    <!-- frequency input -->
                    <div class="col-lg-3">
                      <div class="form-outline">
                        <input v-model="newHabitQuantity" type="text" class="form-control" />
                        <label class="form-label" for="newHabitQuantity">I want to do it:</label>
                      </div>
                    </div>
                    <!-- frequency input -->

                    <!-- quantity input -->
                    <div class="col-lg-3">
                      <div class="form-outline">
                        <input v-model="newHabitFrequency" type="number" class="form-control" />
                        <label class="form-label" for="newHabitQuantity">In a quantity of:</label>
                      </div>
                    </div>
                    <!-- quantity input -->

                    <!-- submit button -->
                    <div class="col-lg-2">
                        <button type="submit" class="btn btn-block habit-button" v-on:click="putHabit()">
                          CREATE
                        </button>
                    </div>
                    <!-- submit button -->
                </div>
               </form>
              <!-- new habit form -->

              <!-- habits cards -->
              <div class="row" style="padding-top: 5%">
                <div class="card h" v-for="habit in habits">
                  <div class="card-body">
                    <div class="card-title single-habit-title">{{ habit.tag }} </div>
                    <div class="card-text single-habit-text">
                      {{habit.quantity}} {{habit.frequency}} {{habit.lastCheck}} {{habit.done}} {{habit.doneAmount}}
                    </div>
                    <button type="button" class="btn btn-rounded habit-button" v-on:click="doneHabit()">DONE</button>
                  </div>
                </div>
              </div>
              <!-- habits cards -->
          
          </div>
    `,
    data() {
        let uid;
        return {
            habits: [],
            uid
            };
        },
    methods: {
        requestHabits(){
            axios.get('/habits/'+this.uid.toString())
                .then(response => {this.habits = response.data; console.log(response.data)});
        },

        createHabit(hidInput){
            let result;

            axios.post('/habits/',{
                done: false,
                doneAmount: 0,
                frequency: this.newHabitFrequency,
                lastCheck: LocalDateTime.now(),
                quantity: this.newHabitQuantity,
                tag: this.newHabitTag
            })
                .then(response => {
                    result = response.data; console.log("new habit created successfully")
                });

            this.requestHabits(this.uid);
        },

        deleteHabit(hidInput){
            axios.delete('/habits/'+hidInput.toString)
                .then(response => {this.habits = response.data; console.log(response.data)});

            this.requestHabits(this.uid);
        },

        doneHabit(hidInput){
            const habit = habits.find(element => element.hid = hidInput);

            axios.put('/habits/' + hidInput.toString, {
                done: true,
                doneAmount: habit.doneAmount + 1,
                frequency: habit.frequency,
                lastCheck: LocalDateTime.now(),
                quantity: habit.quantity,
                tag: habit.tag
            })
                .then(response => {
                    result = response.data;
                    console.log("habit successfully marked as done")
                });

            this.requestHabits(this.uid);

        },

        updateHabit(hidInput, updateFrequency, updateQuantity, updateTag){
            const habit = habits.find(element => element.hid = hidInput);

            axios.put('/habits/' + hidInput, {
                done: habit.done,
                doneAmount: habit.doneAmount,
                frequency: updateFrequency,
                lastCheck: habit.lastCheck,
                quantity: updateQuantity,
                tag: updateTag
            })
                .then(response => {
                    result = response.data;
                    console.log("habit updated successfully")
                });

            this.requestHabits(this.uid);

        },

        getUser(){
            this.uid = '999';
        }
    },
    mounted: function() {
        this.getUser();
        this.requestHabits()
    }
});

app.mount('#habitApp');
