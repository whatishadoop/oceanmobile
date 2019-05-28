<template>
  <div>
    <blockquote class="my-blockquote">注意</blockquote>
    <pre class="my-code">
1、配置时云存储外链域名需带上协议，也就是必须http/https开头，也支持类似kerberos方式认证
2、本次集成了云存储的常用操作，如：上传，下载，删除，同步，支持私有空间上传下载，其中同步按钮可将数据同步到数据库或本地
3、项目中配置存入数据库，如需测试，请使用临时空间进行测试，测试完成及时修改配置，防止数据泄露</pre>
    <blockquote class="my-blockquote">开始使用</blockquote>
    <pre class="my-code">描述使用步骤以....</pre>
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
