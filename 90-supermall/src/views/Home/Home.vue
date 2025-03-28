<template>
  <div id="home">
    <nav-bar class="home-nav"><div slot="center">购物街</div></nav-bar>
    <home-swiper :banners="banners"></home-swiper>
    <home-recommend :recommends="recommends"></home-recommend>
    <feature-view></feature-view>
    <tab-control :titles="['流行', '新款', '精选']"></tab-control>
    <ul>
      <li>列表1</li>
      <li>列表2</li>
      <li>列表3</li>
      <li>列表4</li>
      <li>列表5</li>
      <li>列表6</li>
      <li>列表7</li>
      <li>列表8</li>
      <li>列表9</li>
      <li>列表10</li>
      <li>列表11</li>
      <li>列表12</li>
      <li>列表13</li>
      <li>列表14</li>
      <li>列表15</li>
      <li>列表16</li>
      <li>列表17</li>
      <li>列表18</li>
      <li>列表19</li>
      <li>列表20</li>
      <li>列表21</li>
      <li>列表22</li>
      <li>列表23</li>
      <li>列表24</li>
      <li>列表25</li>
      <li>列表26</li>
      <li>列表27</li>
      <li>列表28</li>
      <li>列表29</li>
      <li>列表30</li>
      <li>列表31</li>
      <li>列表32</li>
      <li>列表33</li>
      <li>列表34</li>
      <li>列表35</li>
      <li>列表36</li>
      <li>列表37</li>
      <li>列表38</li>
      <li>列表39</li>
      <li>列表40</li>
      <li>列表41</li>
      <li>列表42</li>
      <li>列表43</li>
      <li>列表44</li>
      <li>列表45</li>
      <li>列表46</li>
      <li>列表47</li>
      <li>列表48</li>
      <li>列表49</li>
      <li>列表50</li>
      <li>列表51</li>
      <li>列表52</li>
      <li>列表53</li>
      <li>列表54</li>
      <li>列表55</li>
      <li>列表56</li>
      <li>列表57</li>
      <li>列表58</li>
      <li>列表59</li>
      <li>列表60</li>
      <li>列表61</li>
      <li>列表62</li>
      <li>列表63</li>
      <li>列表64</li>
      <li>列表65</li>
      <li>列表66</li>
      <li>列表67</li>
      <li>列表68</li>
      <li>列表69</li>
      <li>列表70</li>
      <li>列表71</li>
      <li>列表72</li>
      <li>列表73</li>
      <li>列表74</li>
      <li>列表75</li>
      <li>列表76</li>
      <li>列表77</li>
      <li>列表78</li>
      <li>列表79</li>
      <li>列表80</li>
      <li>列表81</li>
      <li>列表82</li>
      <li>列表83</li>
      <li>列表84</li>
      <li>列表85</li>
      <li>列表86</li>
      <li>列表87</li>
      <li>列表88</li>
      <li>列表89</li>
      <li>列表90</li>
      <li>列表91</li>
      <li>列表92</li>
      <li>列表93</li>
      <li>列表94</li>
      <li>列表95</li>
      <li>列表96</li>
      <li>列表97</li>
      <li>列表98</li>
      <li>列表99</li>
      <li>列表100</li>
    </ul>
  </div>
</template>

<script>
import HomeSwiper from './childComps/HomeSwiper.vue';
import HomeRecommend from './childComps/HomeRecommend.vue';
import FeatureView from './childComps/FeatureView.vue';

import NavBar from '@/components/common/navBar/NavBar.vue';
import TabControl from '@/components/content/tabControl/TabControl.vue';

import { getHomeMultiData } from '@/network/home';

export default {
  name: 'Home',
  data() {
    return {
      banners: [],
      recommends: []
    }
  },
  components: {
    HomeSwiper,
    HomeRecommend,
    FeatureView,
    NavBar,
    TabControl
  },
  created() {
    /**
     * http://123.207.32.32:7888/api/hy66/home/multidata
     * 获取首页数据
     * 1、安装axios，生产依赖（运行时依赖）
     * 2、封装request.js，看axios官方文档
     * 3、创建network/home.js
     *      引入request.js
     *      关于首页所有的数据请求都封装在home.js
     * 4、在组件创建完成之后，调用异步请求获取数据
     * 5、请求到的数据放在this.data中
     */

     getHomeMultiData().then(res => {
      this.banners = res.data.banner.list;
      this.recommends = res.data.recommend.list;
     })
  },
}
</script>

<style>
.home-nav {
  /* 引用base.css中的变量 --color-tint: #ff8198; */
  background-color: var(--color-tint);
  color: #fff;
  font-weight: 700;

  position: fixed;
  z-index: 10;
  top: 0;
  left: 0;
  right: 0;
}

#home {
  padding-top: 44px;
}

.tab-control {
  /* 
  position:sticky
    1、相对于固定的混合：
        元素在容器内时表现为 position: relative
        当视口滚动达到指定阈值时变为 position: fixed
        元素会一直固定在容器内，直到容器滚动离开视口
    2、必须指定阈值：
        必须设置 top、right、bottom 或 left 中的一个
        例如 top: 10px 表示距离视口顶部 10px 时开始固定
   */
  position: sticky;
  top: 44px;
}
</style>