export default {
    props:['settings-component'],
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

}