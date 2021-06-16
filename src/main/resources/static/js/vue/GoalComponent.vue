<template>
  <mdb-container class="habit_container">
    <!-- content row -->
    <mdb-row>

    </mdb-row>
    <!-- content row -->

    <!-- button row -->
    <mdb-row>
      <!-- new habit button col -->
      <mdb-col size="12" class="text-center mb-5">
        <mdb-btn @click.native="showModal = true" class="habit_button">CREAT NEW GOAL</mdb-btn>
        <mdb-modal :show="showModal" @close="showModal = false" cascade class="text-left">
          <mdb-modal-header class="habit_modal">
            <h4 class="title"><fa class="fas fa-pencil-alt" /> NEW GOAL</h4>
          </mdb-modal-header>
          <mdb-modal-body class="basic_modal" style="color: var(--text-color)">
            <mdb-input size="sm" label="My goal is:" group type="text" validate error="wrong" success="right"/>
            <mdb-input size="sm" label="It's measured in:" group type="number" validate error="wrong" success="right"/>
            <mdb-input size="sm" label="And reached at:" group type="text" validate error="wrong" success="right"/>
            <mdb-input size="sm" label="Currently it's at:" group type="number" validate error="wrong" success="right"/>
          </mdb-modal-body>
          <mdb-modal-footer>
            <mdb-btn style="color: var(--accent-color)" @click.native="showModal = false">exit</mdb-btn>
            <mdb-btn style="color: var(--habit-color)">save</mdb-btn>
          </mdb-modal-footer>
        </mdb-modal>
      </mdb-col>
      <!-- new habit button col -->
    </mdb-row>
    <!-- button row -->
  </mdb-container>
</template>

<script>
import { mdbContainer, mdbRow, mdbCol, mdbInput, mdbTextarea, mdbBtn, mdbIcon, mdbModal, mdbModalHeader, mdbModalBody, mdbModalFooter, mdbSelect } from 'mdbvue';
export default {
  name: 'GoalComponent',
  components: {
    mdbContainer,
    mdbRow,
    mdbCol,
    mdbInput,
    mdbTextarea,
    mdbBtn,
    mdbIcon,
    mdbModal,
    mdbModalHeader,
    mdbModalBody,
    mdbModalFooter,
    mdbSelect
  },
  data() {
    return {
      showModal: false
    };
  }
}
</script>

<style scoped>
@import "./static/css/VueStyle.css";
@import "./static/css/HtmlStyle.css";
</style>