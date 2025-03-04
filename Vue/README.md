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
