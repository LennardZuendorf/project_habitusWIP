const app = Vue.createApp({});

app.component('habit_component', {
    template:
        `
          <link rel="stylesheet" href="./css/vueStyle.css">
          
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
                      {{habit.quantity}} {{habit.frequency}}
                    </div>
                    <button type="button" class="btn btn-rounded habit-button" v-on:click="doneHabit()">DONE</button>
                  </div>
                </div>
              </div>
              <!-- habits cards -->
          
          </div>
    `,
    data() {
        return {
            habits: []
            };
        },
    methods: {
        requestHabits(uidInput){
            axios.get('/habits/all/'+uidInput.toString())
                .then(response => {this.habits = response.data; console.log(response.data)});
        },

        createHabit(){
            axios.post()
                .then(response => {this.habits = response.data; console.log(response.data)});
        },

        deleteHabits(){
            axios.delete()
                .then(response => {this.habits = response.data; console.log(response.data)});
        },

        doneHabit(hidInput){
            axios.put('/habits/'+hidInput.toString())
                .then()

        }
    },
    mounted: function() {
        this.requestHabits(999)
    }
});

app.mount('#habitApp');
