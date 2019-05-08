# oceanmobile

待解决
1.mock测试controller的url 被 @PreAuthorize阻止，去除即可测试，参看Spring Security 与 OAuth2（完整案例）
2.在controller返回DTO对象中，通过@JsonView方法，用来过滤序列化返回对象的属性，参看@JsonView的使用方法
3.针对domain对象自定义注释校验方法 @MyValidConstraint,参看Spring MVC @Validated的使用
  @Valid是javax.validation里的。
  @Validated是@Valid 的一次封装，是Spring提供的校验机制使用。@Valid不提供分组功能
  1、分组
  当一个实体类需要多种验证方式时，例：对于一个实体类的id来说，新增的时候是不需要的，对于更新时是必须的。可以通过groups对验证进行分组，分组接口类（通过向groups分配不同类的class对象，达到分组目的）：
  
  (1)@Validated不分配groups，默认每个没有组的属性每次都要进行验证，分配组不校验，@Validated分配groups 则都只对分组的进行校验

4.参看springmvc 通过 Pageable对象和PageableDefault注解获取分页信息
page，第几页，从0开始，默认为第0页
size，每一页的大小，默认为20
sort，排序相关的信息，以property,property(,ASC|DESC)的方式组织，例如sort=firstname&sort=lastname,desc表示在按firstname正序排列基础上按lastname倒序排列。

5.idea使用技巧  intelliJ idea 使用try/catch 快捷提示按住ctrl + alt + t，JetBrainsIDEA-structure结构继承的图标说明