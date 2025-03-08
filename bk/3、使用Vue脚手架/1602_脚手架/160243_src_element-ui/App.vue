<template>
  <div>
    <h1>Hello World !</h1>
    <ryu-row>
      <ryu-button>默认按钮</ryu-button>
      <ryu-button type="primary">主要按钮</ryu-button>
      <ryu-button type="success">成功按钮</ryu-button>
      <ryu-button type="info">信息按钮</ryu-button>
      <ryu-button type="warning">警告按钮</ryu-button>
      <ryu-button type="danger">危险按钮</ryu-button>
      <ryu-datePicker
        type="datetime"
        placeholder="选择日期时间"
      >
      </ryu-datePicker>
    </ryu-row>
  </div>
</template>

<script>
export default {
  name: "App",
};
</script>

<style></style>
