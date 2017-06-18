package com.shardis.jpa.support

import org.hibernate.boot.MetadataSources
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.cfg.AvailableSettings
import org.hibernate.tool.hbm2ddl.SchemaExport
import org.hibernate.tool.schema.TargetType
import org.reflections.Reflections
import java.io.File
import java.util.*
import javax.persistence.Entity
import javax.persistence.MappedSuperclass

class SchemaExporter(hibernateDialect: String, entityPackages: List<String>, implicitNamingStrategy: String, physicalNamingStrategy: String) {


    val metadataSources: MetadataSources = MetadataSources(
        StandardServiceRegistryBuilder()
            .applySetting(AvailableSettings.DIALECT, hibernateDialect)
            .applySetting(AvailableSettings.IMPLICIT_NAMING_STRATEGY, implicitNamingStrategy)
            .applySetting(AvailableSettings.PHYSICAL_NAMING_STRATEGY, physicalNamingStrategy)
            .build()
    )

    init {
        entityPackages.forEach {
            val reflections = Reflections(it)
            for (cl in reflections.getTypesAnnotatedWith(MappedSuperclass::class.java)) {
                metadataSources.addAnnotatedClass(cl)
            }
            for (cl in reflections.getTypesAnnotatedWith(Entity::class.java)) {
                metadataSources.addAnnotatedClass(cl)
            }
        }
    }

    fun export(exportFile: File) {

        val exporter = SchemaExport()

        exporter
            .setDelimiter(";")
            .setFormat(true)
            .setOutputFile(exportFile.canonicalPath)
            .create(EnumSet.of(TargetType.SCRIPT), metadataSources.buildMetadata())

    }


}
