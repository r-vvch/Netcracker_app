import React from "react";
import {Layout, Menu} from 'antd';
import 'antd/dist/antd.css';
import './App.css';

const {Header, Content, Footer, Sider} = Layout;

export default function App() {
  return (
      <Layout>
          <Header classname={"header"}>
              <div className="logo" />
          </Header>
          <Layout>
              <Sider width={200} className={"sider"}>
                  <Menu
                      mode="inline"
                      defaultSelectedKeys={['1']}
                      defaultOpenKeys={['sub1']}
                      style={{ height: '100%', borderRight: 0 }}
                  >
                      <Menu.Item key={"1"}>option1</Menu.Item>
                      <Menu.Item key={"2"}>option2</Menu.Item>
                      <Menu.Item key={"3"}>option3</Menu.Item>
                  </Menu>
              </Sider>
              <Layout style={{ padding: '0 24px 0' }}>
                  <div style={{ margin: '16px 0' }}> List 1 </div>
                  <Content
                      className="site-layout-background"
                      style={{
                          padding: 24,
                          margin: 0,
                          minHeight: 280,
                      }}
                  >
                      Content
                  </Content>
              </Layout>
          </Layout>
          <Footer className={"footer"} style={{ textAlign: 'center'}}>
              Roman Vovchenko, 2021
          </Footer>
      </Layout>
  );
}
