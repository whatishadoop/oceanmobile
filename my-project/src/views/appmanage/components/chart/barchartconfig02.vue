<template>
  <div>
    <Form :model="formData">
      <Row :gutter="32">
        <Col span="12">
        <FormItem label="Name" label-position="top">
          <Input v-model="formData.name" placeholder="please enter user name"/>
        </FormItem>
        </Col>
        <Col span="12">
        <FormItem label="Url" label-position="top">
          <Input v-model="formData.url" placeholder="please enter url">
          <span slot="prepend">http://</span>
          <span slot="append">.com</span>
          </Input>
        </FormItem>
        </Col>
      </Row>
      <Row :gutter="32">
        <Col span="12">
        <FormItem label="Owner" label-position="top">
          <Select v-model="formData.owner" placeholder="please select an owner">
            <Option value="jobs">Steven Paul Jobs</Option>
            <Option value="ive">Sir Jonathan Paul Ive</Option>
          </Select>
        </FormItem>
        </Col>
        <Col span="12">
        <FormItem label="Type" label-position="top">
          <Select v-model="formData.type" placeholder="please choose the type">
            <Option value="private">Private</Option>
            <Option value="public">Public</Option>
          </Select>
        </FormItem>
        </Col>
      </Row>
      <Row :gutter="32">
        <Col span="12">
        <FormItem label="Approver" label-position="top">
          <Select v-model="formData.approver" placeholder="please choose the approver">
            <Option value="jobs">Steven Paul Jobs</Option>
            <Option value="ive">Sir Jonathan Paul Ive</Option>
          </Select>
        </FormItem>
        </Col>
        <Col span="12">
        <FormItem label="DateTime" label-position="top">
          <DatePicker
            v-model="formData.date"
            type="daterange"
            placeholder="please select the date"
            style="display: block"
            placement="bottom-end">
          </DatePicker>
        </FormItem>
        </Col>
      </Row>
      <FormItem label="Description" label-position="top">
        <Input :rows="4" v-model="formData.desc" type="textarea" placeholder="please enter the description"/>
      </FormItem>
    </Form>
  </div>
</template>

<script type="text/ecmascript-6">
export default {
  data() {
    return {
      formData: {
        name: '',
        url: '',
        owner: '',
        type: '',
        approver: '',
        date: '',
        desc: ''
      }
    }
  }
}
</script>

<style type="text/scss" rel="stylesheet/scss" lang="scss" scoped>

</style>
