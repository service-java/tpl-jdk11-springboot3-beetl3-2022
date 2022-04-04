<%
/*����markdown �ĵ�*/
%>
# ${tableName}


${isEmpty(comment)?"��ע��":comment}

<%
var ids = table.idNames;
%>

| ���� | �������� | ����  |  ˵�� |
| :--: | :--- | :------: |  :----: |
<% for(col in colsMap){

var name = col.key;

if(@ids.contains(name)){
    name="*"+name;
}
var detail = col.value;
var dbType =@org.beetl.sql.clazz.kit.JavaType.jdbcTypeId2Names.get(detail.sqlType);
%>
|${name} | ${dbType}| ${detail.size} |    ${detail.remark} |
<%}%>
