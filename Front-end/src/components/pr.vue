<template>

  <div class="ExitModalForm">
    <b-modal v-model="show"
             title="Вход"
             header-bg-variant="white"
             header-text-variant="dark"
             body-bg-variant="light"
             body-text-variant="dark"
             footer-bg-variant="dark"
             footer-text-variant="light">
       <b-container fluid>
         <div class="d-block text-center">
         </div>
         <b-btn size="lg" class="mt-3" variant="outline-dark" block @click="hideModal">Остаться!</b-btn>
         <b-btn size="lg"class="mt-3" variant="outline-danger" block @click="exit">Выйти</b-btn>
       </b-container>

       <div slot="modal-footer" class="w-100">
         <p class="float-left">© GoAnyWhere Project 2018</p>
       </div>
    </b-modal>
  </div>
</template>

<script>
export default {
  data () {
    return {
      show: false,
    }
  }
}
</script>
