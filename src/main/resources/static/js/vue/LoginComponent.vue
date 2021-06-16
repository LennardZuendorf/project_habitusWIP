<!-- based on code from: https://developer.okta.com/blog/2020/05/15/vue-login, by Holger Schmitz -->

<template>
  <!-- Card -->
  <mdb-card>
    <mdb-card-body>
      <form>
        <p class="h4 text-center py-4">Sign up</p>
        <div class="grey-text">
          <mdb-input label="Your name" icon="user" group type="text" validate error="wrong" success="right"/>
          <mdb-input label="Your email" icon="envelope" group type="email" validate error="wrong" success="right"/>
          <mdb-input label="Confirm your email" icon="exclamation-triangle" group type="text" validate error="wrong" success="right"/>
          <mdb-input label="Your password" icon="lock" group type="password" validate/>
        </div>
        <div class="text-center py-4 mt-3">
          <mdb-btn color="cyan" type="submit">Register</mdb-btn>
        </div>
      </form>
    </mdb-card-body>
  </mdb-card>
  <!-- Card -->
</template>

<script>
import auth from '../auth'
import { mdbContainer, mdbRow, mdbCol, mdbInput, mdbTextarea, mdbBtn, mdbIcon, mdbSelect, mdbCard, mdbCardBody } from 'mdbvue';
export default {
  name: "LoginComponent",
  components: {
    mdbContainer,
    mdbRow,
    mdbCol,
    mdbInput,
    mdbTextarea,
    mdbBtn,
    mdbIcon,
    mdbSelect,
    mdbCard,
    mdbCardBody
  },
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