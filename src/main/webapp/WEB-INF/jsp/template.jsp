
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>
        <tiles:getAsString name="title" />
    </title>
</head>
<body>

    <tiles:insertAttribute name="content" />

</body>
</html> 