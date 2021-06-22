const app = Vue.createApp({});

app.component('test', {
    template: `
        <div>
          {{test}}
        </div>
  `,
    data() {
        return {
            test: "I am a test data"
        };
    }
});

app.mount('#habitApp');