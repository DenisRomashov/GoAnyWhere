<template>
  <div>
      <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
    <b-btn @click="showSingInForm=true" variant="primary">Show Modal</b-btn>

    <b-modal v-model="show"
             title="Вход"
             header-bg-variant="white"
             header-text-variant="dark"
             body-bg-variant="light"
             body-text-variant="dark"
             footer-bg-variant="dark"
             footer-text-variant="light">
       <b-container fluid>
         <b-row>
           <b-col cols="1"></b-col>
           <b-col cols="9">
             <div class="usernameinput">
               <b-input-group >
                   <b-input-group-prepend>
                       <b-btn  variant="dark">Username <i class="fas fa-user"></i></b-btn>
                   </b-input-group-prepend>
                   <b-form-input   type="text">
                 </b-form-input>
               </b-input-group>
             </div>
           </b-col>
           <b-col cols="3"></b-col>
         </b-row>
         <br>
         <b-row>
           <b-col cols="1"></b-col>
           <b-col cols="9">
             <div class="passwordinput">
               <b-input-group >
                   <b-input-group-prepend>
                       <b-btn  variant="dark"> Password <i class="fas fa-unlock-alt"></i></b-btn>
                   </b-input-group-prepend>
                   <b-form-input   type="password">
                 </b-form-input>
               </b-input-group>
             </div>
           </b-col>
           <b-col cols="3"></b-col>
         </b-row>
       </b-container>

       <div slot="modal-footer" class="w-100">
         <p class="float-left">© GoAnyWhere Project 2018</p>
         <b-btn size="" class="float-right" variant="dark" @click="show=false">Войти</b-btn>
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
