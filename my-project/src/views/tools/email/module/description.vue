<template>
  <div>
    <blockquote class="my-blockquote">注意</blockquote>
    <pre class="my-code">
邮件服务器必须支持并打开SMTP协议，详细请查看相关帮助说明
配置文件的样例中提供的是我测试邮件功能注册的sina.com邮箱
帐号密码公开，供测试使用，存入数据库的密码会加密处理，请文明测试</pre>
    <blockquote class="my-blockquote"> 邮件服务器配置</blockquote>
    <pre class="my-code">
 # 邮件服务器的SMTP地址，可选，默认为smtp
 # 邮件服务器的SMTP端口，可选，默认使用网易ssl协议端口465，非ssl协议使用25
 # 发件人（必须正确，否则发送失败）
 # 用户名,可选，默认为发件人邮箱前缀
 # 邮箱密码
 # 是否开启ssl，默认开启</pre>
    <blockquote class="my-blockquote">更多帮助</blockquote>
    <pre class="my-code">更多帮助请参看具体<a style="color:#009688" href="javascript:void(0)">使用手册</a></pre>
  </div>
</template>

<script>
import '@/styles/description.scss'
export default {
  name: 'Description'
}
</script>

<style scoped>
</style>
