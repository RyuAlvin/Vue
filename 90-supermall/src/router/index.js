import Vue from 'vue'
import Router from 'vue-router'

const Home = ()=> import('views/Home/Home.vue')
const Category = ()=> import('views/Category/Category.vue')
const Cart = ()=> import('views/Cart/Cart.vue')
const Profile = ()=> import('views/Profile/Profile.vue')

Vue.use(Router)

const routes = [
  {
  path: '',
  redirect: '/home'
},{
  path: '/home',
  component: Home
},{
  path: '/category',
  component: Category
},{
  path: '/cart',
  component: Cart
},{
  path: '/profile',
  component: Profile
}]

export default new Router({
  routes,
  mode: 'history'
})