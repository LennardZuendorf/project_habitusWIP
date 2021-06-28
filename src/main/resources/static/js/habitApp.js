const app = Vue.createApp({});

app.component('habit_component', {
    template:
        `         
          <!-- new habit form-->
          <div class="container-fluid">
    
              <!-- new habit form -->
              <div class="card habits-form-card">
                <div class="card-body">
                   <form id="newHabitForm">
                     <div class = "row align-items-center justify-content-center">
                        
                       <!-- tag input -->
                        <div class="col-lg-4">
                          <label class="form-label" for="newHabitTag" style>My new habit is:</label>
                          <input v-model="newHabitTag" type="text" id="newHabitTag" class="form-control mr-sm-2" />
                        </div>
                        <!-- tag input -->
                        
                       <!-- frequency input -->
                       <div class="col-lg-3">
                         <label class="form-label" for="newHabitFrequency" style>I want to do it:</label>
                         <select v-model="newHabitFrequency" id="newHabitFrequency" class="form-select mr-sm-2">
                           <option value="daily">daily</option>
                           <option value="weekly">weekly</option>
                           <option value="biweekly">biweekly</option>
                           <option value="triweekly">triweekly</option>
                           <option value="monthly">monthly</option>
                         </select>
                       </div>
                       <!-- frequency input -->
                        
                       <!-- quantity input -->
                        <div class="col-lg-2">
                          <label class="form-label" for="newHabitQuantity" style>In a frequency of:</label>
                          <input v-model="newHabitQuantity" type="number" id="newHabitQuantity" class="form-control mr-sm-2" />
                        </div>
                        <!-- quantity input -->
                       
                       <!-- icon selection -->
                       <div class="col-lg-2">
                         <label class="form-label" for="newHabitIcon" style>Select your icon</label>
                         <select v-model="newHabitIcon" id="newHabitIcon" class="form-select mr-sm-2">
                           <option value="none"> no icon</option>
                           <option value="sport">sport</option>
                           <option value="study">study</option>
                           <option value="community">community</option>
                           <option value="mindfulness">mindfulness</option>
                         </select>
                       </div>
                       <!-- icon selection -->
                       
                       <!-- submit button -->
                        <div class="col-lg-1">
                          <label class="form-label"></label>
                            <button type="submit" class="btn btn-block habit-button" v-on:click="putHabit()" style="height: 3rem !important">
                              CREATE
                            </button>
                        </div>
                        <!-- submit button -->
                    </div>
                   </form> 
                  <!-- new habit form -->
                </div>
              </div>

              <!-- habits cards -->
              <div class="row" style="padding-top: 5%">
                <div class="card habits-list-card border" v-for="habit in habits">
                  <div class="card-body">
                    <div class="card-title card-title-m roboto-bold">
                      {{ habit.tag }} 
                    </div>
                    <div class="card-text">
                      <div class="row justify-content-between">
                        
                        <div class="col-md-6">
                            <form disabled id="habit-display-{{habit.hid}}">
                              <div class="row justify-content-start">
                                <div class="col-lg-4">
                                  <input v-model="updateHabitTag" :placeholder="[[habit.tag]]" type="text" id="updateHabitTag" class="form-control habit-display-form mr-sm-2"/>
                                </div>
                                <div class="col-lg-4">
                                  <input v-model="updateHabitFrequency" :placeholder="[[habit.frequency]]"type="text" id="updateHabitTag" class="form-control habit-display-form mr-sm-2"/>
                                </div>
                                <div class="col-lg-4">
                                  <input v-model="newHabitQuantity" :placeholder="[[habit.quantity]]" type="number" id="newHabitQuantity" class="form-control mr-sm-2 habit-display-form"/>
                                </div>
                              </div>
                            </form>
                        </div>
                        
                        <div class="col-md-3" id="save-edit-button">
                          <button type="button" class="btn btn-floating edit-btns" style="visibility: hidden" onclick="saveEditing(habit.hid)">
                            <i class="fas fa-save"></i>
                          </button>

                          <button type="button" id="edit-button " class="btn btn-floating edit-btns" onclick="toggleEditing(habit.hid)">
                            <i class="fas fa-pen"></i>
                          </button>

                          <button type="button" id="done-button" class="btn btn-rounded habit-button" style="margin-left: 3rem !important;" onclick="doneHabit(habit.hid)">
                            DONE
                          </button>
                        </div>
                        
                      </div>
                    </div>
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

        updateHabit(hidInput){
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

        toggleEditing(hidInput){
            const habitDisplay = document.getElementById("habit-display"+hidInput.toString());
            habitDisplay.toggleAttribute("disabled");
            if(habitDisplay.style.outline !== "var(--habit-color)"){
                habitDisplay.style.outline = "var(--habit-color)";
            }else {habitDisplay.style.outline = "none !important";}
            this.toggleSaveButton();
        },

        saveEditing(hidInput){
            const habitDisplay = document.getElementById("habit-display"+hidInput.toString());
            habitDisplay.toggleAttribute("disabled");
            this.updateHabit(hidInput);
        },

        toggleSaveButton(){
            const btn = document.getElementById("save-edit-button");
            if (btn.style.visibility === "hidden"){
                btn.style.display = "visible";
            } else {btn.style.display = "hidden";}
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
