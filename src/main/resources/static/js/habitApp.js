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
                    <div class="row align-items-center justify-content-center">
    
                      <!-- tag input -->
                      <div class="col-lg-4">
                        <label class="form-label" for="newHabitTag" style>My new habit is:</label>
                        <input v-model="newHabitTag" type="text" id="newHabitTag" class="form-control mr-sm-2"/>
                      </div>
                      <!-- tag input -->
    
                      <!-- frequency input -->
                      <div class="col-lg-2">
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
                        <input v-model="newHabitQuantity" type="number" id="newHabitQuantity" class="form-control mr-sm-2"/>
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
                        <button type="submit" class="btn btn-rounded habit-button" v-on:click="createHabit()"
                                style="height: 3rem !important">
                          CREATE
                        </button>
                      </div>
                      <!-- submit button -->
                    </div>
                  </form>
                  <!-- new habit form -->
                </div>
              </div>

              <!--update habit form row-->
              <div class="row justify-content-start" id="habit-display-edit-form" style="visibility:collapse; display:none">
                <div class="card">
                  <div class="card-body">
                    <div class="card-text">
                        <form>
                          <div class="col-md-5">
                            <input v-model="updateHabitTag" :placeholder="[[updatingHabit.tag]]" type="text" id="updateHabitTag" class="form-control habit-display-form mr-sm-2"/>
                          </div>
                          <div class="col-md-3">
                            <select v-model="updateHabitFrequency" id="updateHabitFrequency" class="form-select mr-sm-2 habit-display-form">
                              <option value="daily">daily</option>
                              <option value="weekly">weekly</option>
                              <option value="biweekly">biweekly</option>
                              <option value="triweekly">triweekly</option>
                              <option value="monthly">monthly</option>
                            </select>
                          </div>
                          <div class="col-md-3">
                            <input v-model="updateHabitQuantity" :placeholder="[[updatingHabit.quantity]]+' times'" type="number"
                                   id="newHabitQuantity" class="form-control mr-sm-2 habit-display-form"/>
                          </div>
                          <button type="button" id="edit-button" class="btn btn-floating edit-btns" v-on:click="saveEditing(updatingHabit.hid)">
                            <i class="fas fa-save"></i></button>
                        </form>
                    </div>
                  </div>
                </div>
                  <!--update habit form row-->
              </div>          
    
              <!-- habits cards -->
              <div class="row" style="padding-top: 5%">
                <div class="card habits-list-card border" v-for="habit in habits" v-if="!habit.done">
    
                  <div class="card-body">
                    <!--card title-->
                    <div class="card-title card-title-m roboto-bold">
                      {{ habit.tag }}
                    </div>
                    <!--card title-->
                    
                    <!--card text-->
                    <div class="card-text">
                          <!--habit information & buttons row-->
                          <div class="row justify-content-between align-items-center">
                            
                            <div class="col-md-9 roboto-medium">
                                <div class="habit-display-text"> Your doing &nbsp</div>
                                <div class="habit-display-text roboto-black vue-input-style"> {{ habit.tag }} &nbsp </div>
                                <div class="habit-display-text"> in a &nbsp </div>
                                <div class="habit-display-text roboto-black vue-input-style "> {{ habit.frequency }} &nbsp </div>
                                <div class="habit-display-text"> frequency, &nbsp </div>
                                <div class="habit-display-text roboto-black vue-input-style"> {{ habit.quantity }} &nbsp </div>
                                <div class="habit-display-text"> time(s) a period.</div>
                            </div>
    
                            <div class="col-md-3">
                              <button type="button" id="edit-button " class="btn btn-floating edit-btns" v-on:onclick="toggleEditing(habit.hid)"><i class="fas fa-pen"></i></button>
                              <button type="button" id="done-button" class="btn btn-rounded habit-button" style="margin-left: 1rem !important;" v-on:click="doneHabit(habit.hid)">DONE</button>
                            </div>
                          </div>
                      <!--habit information row-->
                    </div>
                    <!--card text-->
                  </div>
                </div>
                <!--card text-->
              </div>
              <!-- habits cards -->
          </div>
        `,
    data() {
        let url
        let uid;
        let updatingHabit;
        return {
            habits: [],
            url: "/habits/",
            updatingHabit:{
                hid: 9999,
                frequency: "DAILY",
                quantity: 1,
                tag: "9999"
            },
            uid
            };
        },

    methods: {
        requestHabits(){
            let URL;
            URL = this.url + this.uid.toString();

            axios.get(URL)
                .then(response => {this.habits = response.data; console.log(response.data)});
        },

        createHabit(hidInput){
            let result;
            let URL;
            URL = this.url + hidInput.toString();

            axios.post(URL,{
                done: false,
                doneAmount: 0,
                frequency: this.newHabitFrequency,
                lastCheck: LocalDateTime.now(),
                quantity: this.newHabitQuantity,
                tag: this.newHabitTag,
                uid: this.uid
            })
                .then(response => {
                    result = response.data; console.log("new habit created successfully")
                });

            this.requestHabits(this.uid);
        },

        deleteHabit(hidInput){
            let URL;
            URL = this.url + hidInput.toString();

            axios.delete(URL)
                .then(response => {this.habits = response.data; console.log(response.data)});

            this.requestHabits(this.uid);
        },

        doneHabit(hidInput){
            const habit = this.habits.find(element => element.hid = hidInput);
            let URL;
            URL = this.url + hidInput.toString();
            let newAmount = habit.doneAmount+1;

            axios.put(URL, {
                done: habit.done,
                doneAmount: newAmount,
                frequency: habit.frequency,
                quantity: habit.quantity,
                tag: habit.tag,
                uid: habit.uid
            })
                .then(response => {
                    console.log("habit successfully marked as done");
                    this.requestHabits(this.uid);
                });
        },

        updateHabit(hidInput){
            const habit = habits.find(element => element.hid = hidInput);
            let URL;
            URL = this.url + hidInput.toString();

            axios.put(URL, {
                done: habit.done,
                doneAmount: habit.doneAmount,
                frequency: updateFrequency,
                quantity: updateQuantity,
                tag: updateTag,
                uid: this.uid
            })
                .then(response => {
                    result = response.data;
                    console.log("habit updated successfully");
                    this.requestHabits(this.uid);
                });

        },

        saveEditing(hidInput){
            this.updateHabit(hidInput);
            this.toggleEditing(hidInput);
        },

        toggleEditing(hidInput){
            const habitEditForm = document.getElementById("habit-display-edit-form");
            this.setUpdateHabit(hidInput);

            if (habitEditForm.style.visibility === "collapsed"){
                habitEditForm.style.visibility = "visible";
                habitEditForm.style.display = "block";
            } else {
                habitEditForm.style.display = "collapsed";
                habitEditForm.style.display= "none";
            }
        },

        getUser(){
            this.uid = '999';
        },

        setUpdateHabit(hidInput){
            const habit = this.habits.find(element => element.hid = hidInput);

            this.updatingHabit.hid = hidInput;
            this.updatingHabit.tag = habit.tag;
            this.updatingHabit.frequency = habit.frequency;
            this.updatingHabit.quantity = habit.quantity;
            },
    },

    mounted: function() {
        this.getUser();
        this.requestHabits()
    }
});

app.mount('#habitApp');
