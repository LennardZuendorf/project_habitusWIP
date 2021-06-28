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

          <!-- habits cards -->
          <div class="row" style="padding-top: 5%">
            <div class="card habits-list-card border" v-for="habit in habits" :done='false'>

              <div class="card-body">
                <!--card title-->
                <div class="card-title card-title-m roboto-bold">
                  {{ habit.tag }}
                </div>
                <!--card title-->
                <!--card text-->
                <div class="card-text">
                      <!--habit information & buuttons row-->
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
                          <button type="button" id="save-edit-button-[[habit.hid]]" class="btn btn-floating edit-btns" style="visibility: hidden" v-on:click="saveEditing(habit.hid)">
                            <i class="fas fa-save"></i></button>

                          <button type="button" id="edit-button " class="btn btn-floating edit-btns" v-on:onclick="toggleEditing(habit.hid)">
                            <i class="fas fa-pen"></i></button>

                          <button type="button" id="done-button" class="btn btn-rounded habit-button" style="margin-left: 1rem !important;" v-on:click="doneHabit(habit.hid)">
                            DONE</button>
                        </div>
                      </div>
                      <!--habit information row-->

                      <!--update habit form row-->
                      <div class="row justify-content-start" id="habit-display-edit-form-[[habit.hid]]" style="visibility:collapse; display:none">
                        <form>
                        
                          <div class="col-md-5">
                            <input v-model="updateHabitTag" :placeholder="[[habit.tag]]" type="text" id="updateHabitTag" class="form-control habit-display-form mr-sm-2"/>
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
                            <input v-model="newHabitQuantity" :placeholder="[[habit.quantity]]+' times'" type="number"
                                   id="newHabitQuantity" class="form-control mr-sm-2 habit-display-form"/>
                          </div>
                        </form>
                      </div>
                      <!--update habit form row-->
                    </div>
                    <!--habit information and form col-->
                  </div>
                </div>
                <!--card text-->
              </div>
            </div>
            <!-- habits cards -->
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
                tag: this.newHabitTag,
                uid: this.uid
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
            const habit = this.habits.find(element => element.hid = hidInput);
            const URL = '/habits/' + habit.hid.toString();

            console.log(URL)
            console.log(habit)
            console.log(hidInput)

            axios.put(URL, {
                done: habit.done,
                doneAmount: habit.doneAmount+1,
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

            axios.put('/habits/' + hidInput, {
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
            this.toggleSaveButton(hidInput);
        },

        toggleEditing(hidInput){
            const habitEditForm = document.getElementById("habit-display-edit-form-"+hidInput.toString());
            if (habitEditForm.style.visibility === "collapsed"){
                habitEditForm.style.visibility = "visible";
                habitEditForm.style.display = "block";
            } else {
                habitEditForm.style.display = "collapsed";
                habitEditForm.style.display= "none";
            }
            this.toggleSaveButton();
        },

        toggleSaveButton(hidInput){
            const btn = document.getElementById("save-edit-button-"+hidInput.toString());
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
