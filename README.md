# MVVM模型

![image-20240707225450181](./assets/image-20240707225450181.png)

![image-20240707225339755](./assets/image-20240707225339755.png)

1. data中所有的属性，最后都出现在了vm身上；
2. vm身上所有的属性，及Vue原型上所有属性，在Vue模板中都可以直接使用。

# 数据代理

![image-20240713135649925](./assets/image-20240713135649925.png)

# 组件的key属性

![image-20250101140023587](./assets/image-20250101140023587.png)

# 注册组件的基本步骤

![image-20250102222434884](./assets/image-20250102222434884.png)

# 父子组件的通信

![image-20250103194313447](./assets/image-20250103194313447.png)

# 什么是Webpack

![image-20250106233829607](./assets/image-20250106233829607.png)

# 前端模块化

![image-20250106234455548](./assets/image-20250106234455548.png)      

# Webpack安装

![image-20250107001318708](./assets/image-20250107001318708.png)

![image-20250109212730525](./assets/image-20250109212730525.png)

# Node.js相关

![image-20250109003719660](./assets/image-20250109003719660.png)

![image-20250109003940202](./assets/image-20250109003940202.png)

```json
{
  "name": "meetwebpack",
  "version": "1.0.0",
  "description": "",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "author": "",
  "license": "ISC" // 项目开源才需要写这个
}
```

![image-20250109214243743](./assets/image-20250109214243743.png)

# 什么是loader

![image-20250109214633971](./assets/image-20250109214633971.png)

# 什么是Vue CLI

![image-20250113164742189](./assets/image-20250113164742189.png)

# Vue CLI的使用

这里安装的是Vue CLI3的版本，如果需要想按照Vue CLI2的方式初始化项目是不可以的。

也就是说，只能通过脚手架3来创建vue项目，但是在创建的时候可以通过选择模板的方式指定是vue2的项目还是vue3的项目。

```bash
# 安装最新版本
npm install -g @vue/cli
# 安装指定版本
npm install -g @vue/cli@<version>
# 查看版本
vue --version
# Vue CLI3和旧版使用了相同的vue命令，所以Vue CLI2（vue-cli）被覆盖了。如果你仍然需要使用旧版本的vue init功能，你可以全局安装一个桥接工具
npm install -g @vue/cli-init
# Vue CLI2初始化项目
vue init webpack <project name>
# Vue CLI3初始化项目
vue create <project name>
```

![image-20250113171004746](./assets/image-20250113171004746.png)

![image-20250113175347972](./assets/image-20250113175347972.png)

# Vue程序运行过程

![image-20250115203917776](./assets/image-20250115203917776.png)

# npm run build

![image-20250115225541261](./assets/image-20250115225541261.png)

# npm run dev

![image-20250115225646973](./assets/image-20250115225646973.png)

# Vue CLI3配置文件的查看和修改

> 图形化界面

```bash
# GUI
vue ui
```

> 实际配置文件

![image-20250116194630864](./assets/image-20250116194630864.png)

![image-20250116194824375](./assets/image-20250116194824375.png)

# 后端路由阶段

![image-20250116213411784](./assets/image-20250116213411784.png)

# 前端路由阶段

![image-20250116213615673](./assets/image-20250116213615673.png)

# 打包文件解析

![image-20250119181520952](./assets/image-20250119181520952.png)

# 路由的懒加载

![image-20250119182919296](./assets/image-20250119182919296.png)

![image-20250119183535776](./assets/image-20250119183535776.png)

# Vue2生命周期

![130201_生命周期](./assets/生命周期.png)

# Promise的三种状态

![image-20250302220620553](./assets/image-20250302220620553.png)

# Vuex状态管理

![image-20250303201147566](./assets/image-20250303201147566.png)

- 组件之间如何改变共享状态？
  - 通过提交mutation的方式，而非直接改变state中的数据。
- 为什么官方不推荐在组件中直接修改state中的数据？
  1. 状态追踪困难：直接修改state导致状态变化难以追踪，调试和排查问题困难；
  2. 破坏单相数据流：Vuex推崇单向数据流：View -> Actions -> Mutations -> State -> View。直接修改state会破坏这一流程，增加代码的不可预测性；
  3. 失去Vuex工具支持：Vuex提供的开发工具（如Vue Devtools）依赖于mutations来记录状态变化，直接修改state会导致这些工具无法正常工作，影响调试效率。

# Vuex State的响应式原理

Vuex 的 state 是基于 Vue 的响应式系统实现的。具体来说：

- Vuex 在初始化时，会使用 `Vue.observable()`（Vue 2.x）或 `reactive()`（Vue 3.x）将 state 对象转换为响应式对象；
- 当组件通过 `mapState` 或 `this.$store.state` 访问 state 时，Vue 会自动追踪这些依赖；
- 当 state 中的数据发生变化时，Vue 会通知所有依赖该数据的组件进行更新；
- 如果直接修改 state 中的数据，Vuex 会检测到变化并触发视图更新。但这种方式不推荐，因为它绕过了 Vuex 的调试工具，难以追踪状态变化；
- 推荐通过提交 mutation 来修改 state，这样可以确保状态变化的可追踪性。

# 不推荐在mutations中异步操作更改state

这是由Vuex的设计原则和工作机制决定的。以下是具体原因和解释：

1. mutations的职责。mutations的主要职责是同步地修改state。Vuex的设计理念是：
   - 同步操作：mutations必须是同步的，以确保每次state的变化都可以被清晰地追踪和调试；
   - 可预测性：同步操作使得state的变化是线性的、可预测性的，便于调试工具（Devtools）记录和回放状态变化；
2. 正确的做法：使用actions。Vuex提供了actions来处理异步操作，actions的设计就是为了解决异步操作的问题：
   - 异步操作完成后，通过commit提交mutations来修改state；

# 选择什么网络模块

选择一：传统的Ajax是基于XMLHttpRequest(XHR)，为什么不用？

- 配置和调用非常混乱，编码蛋疼。真实开发中很少直接使用而是是应用jQuery-Ajax；

选择二：jQuery-Ajax：相对于传统的Ajax非常好用，但为什么不用？

- 在Vue的整个开发中都是不需要jQuery。我们为了方便进行一个网络请求，特意需要引用一个jQuery，不合理；
- jQuery的代码1W+行，Vue的代码才1W+行。完全没有必要为了用网络请求就引用这个重量级框架；

选择三：Vue1.x Resource，相对于jQuery小很多，也是Vue官方推出的，为什么不用？

- 在Vue2.0推出后，Vue官网就去掉了Vue-resource，意味着不再更新和维护，对以后的项目开发和维护都存在着很大的隐患；

选择四：axios，Vue官方宣布不再维护Vue-resource后，推荐使用axios。

# <%= BASE_URL %>

![image-20250322115346808](./assets/image-20250322115346808.png)

<%= BASE_URL %>是Vue CLI项目中的模板语法，用于动态插入publicPath（基础路径）。

BASE_URL是Vue CLI提供的一个环境变量，表示项目的基础路径（默认为 / ）。

BASE_URL会根据项目的部署环境动态变化。例如：

- 开发环境：BASE_URL通常是 / 。
- 生产环境：如果项目部署在子路径下（如https://example.com/my-app/），BASE_URL会是 /my-app/ 。
