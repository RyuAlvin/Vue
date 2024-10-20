package org.yeahicode.rbac.convert;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import org.yeahicode.rbac.domain.Hr;
import org.yeahicode.rbac.domain.Tester1;
import org.yeahicode.rbac.model.HrModel;

@Mapper // 默认使用工厂方式获取
//@Mapper(componentModel = "cdi", injectionStrategy = InjectionStrategy.CONSTRUCTOR) // cdi采用@Inject方法注入
//@Mapper(componentModel = "jsr330", injectionStrategy = InjectionStrategy.CONSTRUCTOR) // cdi采用@Inject方法注入
//@Mapper(componentModel = "spring") // 采用@Autowired注入
public interface ConvertDo2Model {

    // 获取该类自动生成的实现类的实例
    ConvertDo2Model INSTANCES = Mappers.getMapper(ConvertDo2Model.class);

    @Mappings({
            @Mapping(source = "hr.id",target = "id"),
            @Mapping(source = "hr.name",target = "name", defaultValue = "no name"),
            @Mapping(source = "hr.username",target = "username"),
            @Mapping(source = "hr.password",target = "password")})
    HrModel convert1(Tester1 tester1, Hr hr);

//    public HrModel convert1(Hr hr) {
//        if (hr == null) {
//            return new HrModel();
//        }
//        return HrModel.builder()
//                .id(hr.getId())
//                .name(hr.getName())
//                .username(hr.getUsername())
//                .password(hr.getPassword())
//                .build();
//    }

    @Mappings({
            @Mapping(source = "name",target = "name"),
            @Mapping(source = "phone",target = "phone"),
            @Mapping(source = "telephone",target = "telephone")})
    HrModel convert2(Hr hr);

//    public HrModel convert2(Hr hr) {
//        if (hr == null) {
//            return new HrModel();
//        }
//        return HrModel.builder()
//                .name(hr.getName())
//                .phone(hr.getPhone())
//                .telephone(hr.getTelephone())
//                .build();
//    }
}
