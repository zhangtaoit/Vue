import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Home from '@/components/Home'
import addMovie from '@/components/addMovie'
import editMovie from '@/components/editMovie'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/home',
      name: 'Home',
      component: Home,
      meta:{
        reqiredAuth:true
      }
    },
    {
      path: '/new',
      name: 'addMovie',
      component: addMovie,
      meta:{
        reqiredAuth:true
      }
    },
    {
      path: '/edit/:id',
      name: 'editMovie',
      component: editMovie,
      meta:{
        reqiredAuth:true
      }
    }
  ]
})
