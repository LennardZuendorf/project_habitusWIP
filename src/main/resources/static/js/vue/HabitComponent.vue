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
        <mdb-btn @click.native="showModal = true" class="habit_button">CREAT NEW HABIT</mdb-btn>
        <mdb-modal :show="showModal" @close="showModal = false" cascade class="text-left">
          <mdb-modal-header class="habit_modal">
            <h4 class="title"><fa class="fas fa-pencil-alt" /> NEW HABIT</h4>
          </mdb-modal-header>
          <mdb-modal-body class="basic_modal" style="color: var(--text-color)">
            <mdb-input size="sm" label="I want to:" group type="text" validate error="wrong" success="right"/>
            <mdb-input size="sm" label="How often?" group type="number" validate error="wrong" success="right"/>
            <mdb-select class="browser-default custom-select">
              <option selected> select a frequency </option>
              <option value="1"> DAILY </option>
              <option value="2"> WEEKLY </option>
              <option value="3"> BIWEEKLY </option>
              <option value="4"> TRIWEEKLY </option>
              <option value="5"> MONTHLY </option>
            </mdb-select>
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
    name: 'HabitComponent',
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