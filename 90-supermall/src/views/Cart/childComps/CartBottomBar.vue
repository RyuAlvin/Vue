<template>
  <div class="bottom-menu">
    <check-button :isChecked="isSelectAll" class="select-all" @click.native="checkClick"/>
    <span class="select-all-title">全选</span>
    <span class="total-price">合计：{{ totalPrice }}</span>
    <span class="buy-product">去计算({{ checkLength }})</span>
  </div>
</template>

<script>
import CheckButton from '@/components/content/checkButton/CheckButton.vue';
import { mapGetters } from 'vuex';

export default {
  components: { CheckButton },
  name: 'CartBottomBar',
  computed: {
    ...mapGetters(['cartList']),
    checkLength() {
      return this.cartList.filter(item => item.checked).length;
    },
    totalPrice() {
      return '￥' + this.cartList.filter(item => {
        return item.checked
      }).reduce((prev, val) => {
        return prev + val.newPrice * val.count
      }, 0).toFixed(2);
    },
    isSelectAll() {
      /**
       * 全部选中为true，只要有一个没选中为false
       * 遍历，只要找到没有选中的就返回false
       * filter、find、for...of
       */
      // return this.cartList.length > 0 && !(this.cartList.filter(item => !item.checked).length > 0);
      // return this.cartList.length > 0 && !this.cartList.find(item => !item.checked);

      if(this.cartList.length === 0) return false;

      for(let item of this.cartList) {
        if(!item.checked) {
          return false
        }
      }

      return true;
    }
  },
  methods: {
    checkClick() {
      /**
       * 在这里不能用 this.cartList.forEach(item => item.checked = !this.isSelectAll);
       * 因为this.isSelectAll也是通过判断每个item.checked计算得出，会互相影响
       */
      if(this.isSelectAll) {
        this.cartList.forEach(item => item.checked = false);
      } else {
        this.cartList.forEach(item => item.checked = true);
      }
    }
  },
}
</script>

<style scoped>
  .bottom-menu {
    width: 100%;
    height: 44px;
    background-color: #eee;
    position: fixed;
    bottom: 50px;
    left: 0;
    /* box-shadow: 0 -2px 3px rgba(0, 0, 0, .2); */
    font-size: 14px;
    color: #888;
    line-height: 44px;
    padding-left: 35px;
    box-sizing: border-box;
  }

  .bottom-menu .select-all {
    position: absolute;
    line-height: 0;
    left: 12px;
    top: 10px;
  }

  .bottom-menu .select-all-title {
    margin-left: 5px;
  }

  .bottom-menu .total-price {
    margin-left: 15px;
    font-size: 16px;
    color: #666;
  }

  .bottom-menu .buy-product {
    background-color: orangered;
    color: #fff;
    width: 100px;
    height: 44px;
    text-align: center;
    line-height: 44px;
    float: right;
  }
</style>