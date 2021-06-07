<!-- based on code from: https://developer.okta.com/blog/2020/05/15/vue-login, by Holger Schmitz -->

<template>
  <div>
    <h2>Login</h2>
    <p v-if="$route.query.redirect">
      You need to login first.
    </p>
    <form @submit.prevent="login" autocomplete="off">
      <label><input v-model="email" placeholder="email" v-focus></label>
      <label><input v-model="pass" placeholder="password" type="password"></label><br>
      <button type="submit">login</button>
      <p v-if="error" class="error">Bad login information</p>
    </form>
  </div>
</template>

<script>
import auth from '../auth'

export default {
  data () {
    return {
      email: '',
      pass: '',
      error: false
    }
  },
  methods: {
    login () {
      auth.login(this.email, this.pass, loggedIn => {
        if (!loggedIn) {
          this.error = true
        } else {
          this.$router.replace(this.$route.query.redirect || '/')
        }
      })
    }
  }
}
</script>

<style>
  @import "src/main/resources/static/css/VueStyle.css";
  @import "src/main/resources/static/css/HtmlStyle.css";
</style>