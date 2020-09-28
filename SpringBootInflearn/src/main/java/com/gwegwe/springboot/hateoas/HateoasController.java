package com.gwegwe.springboot.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hate")
public class HateoasController {

  @GetMapping(value = "/hateoas", produces = MediaType.APPLICATION_JSON_VALUE)
  public EntityModel<Hello> hateoas() {
    Hello hello = new Hello();
    hello.setName("biglight");

    EntityModel<Hello> entityModel = EntityModel.of(hello,
        linkTo(methodOn(HateoasController.class).hateoas()).withSelfRel());
    return entityModel;
  }
}
